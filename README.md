# trial-and-error

## 하나의 깃 저장소, 서로 다른 위치의 작업 디렉토리

### 상황

- `C:\Users\J\Dropbox\...\SIST`에 깃 저장소의 `main` 브랜치 존재
	+ `SIST [main]`
		* `docs`
		* `src`
- `C:\javaWork\workspace` 내에 이클립스로 작성한 자바 코드들 존재
	+ `workspace`
		* `ch01-basic`
		* `ch02-operator`

### 문제

- 기존의 깃 저장소와 이클립스 workspace의 경로를 모두 유지하면서, 이클립스 workspace를 깃 저장소에 추가

### 해결

1. 기존의 깃 저장소에서 `worktree`를 이용하여 내용물이 없는 새 브랜치 폴더를 생성하고, 원격 저장소에 해당 브랜치를 푸시
```sh
# SIST 폴더에 sync 폴더와 sync 브랜치 생성
git worktree add <브랜치명>
# SIST\sync 폴더로 이동
cd <폴더명>
# 첫 번째 커밋의 ID를 출력
git rev-list --max-parents=0 --abbrev-commit HEAD
# sync 브랜치를 첫 번째 커밋으로 초기화
git reset --hard <커밋 ID>
# 원격 저장소에 파일 및 커밋 히스토리가 비워진 sync 브랜치를 푸시
git push -u origin <브랜치명>
```
2. 새 브랜치를 작업할 실제 폴더의 상위 디렉토리로 이동 후, `git clone --single-branch`를 활용하여 실제 폴더를 원격 저장소의 새 브랜치에 추가
```sh
# sync 브랜치를 작업할 실제 디렉토리 workspace의 상위 디렉토리 javaWork로 이동
cd <상위 폴더명>
# workspace의 경우 이미 내용물이 있어 git clone이 불가하므로, 임시 디렉토리 temp를 생성하고 원격 저장소의 sync 브랜치만 clone
git clone -b <브랜치명> --single-branch <원격 저장소 URL> <임시 폴더명>
# temp/.git 디렉토리를 workspace 안으로 이동
mv <임시 폴더명>/.git <실제 폴더명>
# workspace로 이동하면 sync 브랜치로 인식됨
cd <실제 폴더명>
```
3. 기존의 깃 저장소 `main` 브랜치의 `.gitignore`에 새 브랜치 폴더를 추가하여, `main` 브랜치에서는 worktree의 변경 내역을 신경쓰지 않도록 함
```sh
# SIST/.gitignore에 sync/를 추가
<새 브랜치명>/
```

### 결과

- `C:\Users\J\Dropbox\...\SIST`에 깃 저장소의 `main` 브랜치 존재
	+ `SIST [main]`
		* `docs`
		* `src`
		* ~~`sync`~~: `.gitignore`에 의해 무시됨
- `C:\javaWork\workspace`에 깃 저장소의 `sync` 브랜치 존재
	+ `workspace [sync]`
		* `ch01-basic`
		* `ch02-operator`

## Set encoding to UTF-8

### 상황

- 이클립스에서 지금까지 기본 인코딩을 MS949로 둔 채 자바 코드들을 작성해 왔음

### 문제

- Window-Preferences-General에서 Content Types-Text와 Workspace의 인코딩을 UTF-8로 변경시, 기존 파일 내 한글 주석이 깨짐

### 해결

- [UNIX의 `find` 명령을 이용하여 파일 인코딩을 일괄 변환](http://egloos.zum.com/mcchae/v/10938486)
```sh
# 이클립스 workspace로 이동
cd c:/javaWork/workspace
# 현재 경로의 각 하위 디렉토리로 이동하여 모든 파일에 대해 인코딩을 EUC-KR에서 UTF-8로 변경
find . -type f -execdir iconv -f euckr -t utf-8 {} -o {}.tmp \; -execdir mv -f {}.tmp {} \;
# 인코딩 변경 과정에서 발생한 임시 파일 찌꺼기 제거
find . -name '*.tmp' -exec rm {} \;
```

#### 의문

- PowerShell의 `Get-Content`, `Set-Content` 명령을 시도해보았지만, 다른 프로세스에 의해 사용 중이라 액세스할 수 없다는 에러 발생(PC를 다시 시작해도 증상 지속)
```sh
Get-Content .\*.java | Set-Content .\*.java -Encoding utf8
```
- `file` 명령으로 확인한 인코딩은 ISO-8859-1이었는데, 인코딩을 [ISO-8859-1에서 UTF-8로 변경](http://www.coolnix.net/2016/08/파일인코딩-변경법-리눅스에서-일괄변경/) 후 이클립스에서 파일을 열어보면 여전히 한글이 깨져 있음
```sh
# 파일의 인코딩 확인
file -bi NoteDAO.java
# 디렉토리 내 모든 .java 파일에 대해 인코딩을 ISO-8859-1에서 UTF-8로 변경
find . -name "*.java" -exec iconv -f ISO-8859-1 -t UTF-8 {} -o {} \;
# 디렉토리 내 모든 .java 파일에 대해 잘못된 개행 문자 수정
perl -pi -e 's/\n/\r\n/g' *.java
```

### 결과

- 이클립스에서 기존 파일을 임의로 선택하여 열었을 때, 한글 주석이 깨지지 않는 것을 확인
- 264개의 `.java` 파일을 한 번에 커밋하는 대참사 발생

## 이클립스에서 JavaScript 선택된 항목 배경색 변경

### 상황

- 전체적으로는 Eclipse Color Theme 플러그인을 이용하여 `*.xml` 형식의 커스텀 테마가 적용되어 있음
- JS 파일의 경우 해당 테마가 무시되고 Window-Preferences-TextMate-Theme 혹은 소스 편집 창에서 오른쪽 클릭시 Switch to Theme...를 선택하여 확인할 수 있는 `*.css` 형식의 테마가 적용되어 있음

### 문제

- `*.js` 파일에서 현재 선택된 항목 배경색이 지나치게 밝아 가독성을 심각하게 해침
- TextMate가 제공하는 **어떤 테마를 선택하더라도 현재 선택된 항목의 배경색이 바뀌지 않고**, Eclipse Color Theme의 설정도 유효하지 않음
	+ JS 파일만 밝은 테마를 쓴다면 문제가 되지 않을 수 있지만, 어두운 테마를 사용하고 싶음

### 해결

- `eclipse javascript occurrence color`로 검색하여 발견한 스택오버플로우 글에서 상위 추천 답변은 아니지만, [혹시 JS 파일 문제라면...](https://stackoverflow.com/a/44987153)으로 시작하는 답변을 발견
- (아마도 버전 차이로 인해) 해당 답변에 첨부된 스크린샷과 달리 JavaScript Occurences는 없었지만, 대신 **LSP Read Occurrence**의 색을 변경하여 해결(Text, Write도 변경해보았지만 영향 없었음)

## eGovFrame의 외부 웹 브라우저로 Microsoft Edge 추가

### 문제

- eGovFrame 개발자용 개발환경 3.10.0 버전에는 Window-Web Browser에서 제공하는 항목에 Microsoft Edge가 없음

### 해결

- Window-Preferences-General-Web Browser에서 New...를 선택하여 경로에 `C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe`를 입력하고 추가
	+ 시작 메뉴에 있는 Microsoft Edge 바로가기 파일의 속성에서 대상 경로를 확보 가능
