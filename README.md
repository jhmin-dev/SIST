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