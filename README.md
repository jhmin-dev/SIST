# [SIST](https://jhmin-dev.github.io/SIST)

매일 수업 들으며 정리한 노트 모음

## Tools

- Sublime Text 4
	+ PlainNotes (syntax)
	+ MarkdownEditing (key bindings)
	+ MarkdownPreview, LiveReload (live preview)
	+ Terminus (git on Ubuntu 18.04 via WSL 2)
		* `RunJava.sublime-build` (to build Java within ST 4)
		```json
		{
			"target": "terminus_exec",
			"cancel": "terminus_cancel_build",
			"working_dir": "$file_path",
			"shell_cmd": "javac -d . $file -encoding UTF-8 && java $file_base_name",
			"selector": "source.java",
		}
		```
		* `RunJavaProject.sublime-build` (to build Java packages within ST 4)
		```json
		{
			"target": "terminus_exec",
			"cancel": "terminus_cancel_build",
			"working_dir": "$file_path",
			"shell_cmd": "javac -d ../../bin -cp ../../lib/*;../../bin -encoding UTF-8 *.java && for %I in (.) do java -cp ../../lib/*;../../bin %~nxI.$file_base_name",
			"selector": "source.java",
		}
		```
	+ ProjectSpecificKeys (key bindings)
		* `myminiprj.sublime-project` (to build with specific build system within specific project)
		```json
		"keys":
		[
			{
				"keys": ["ctrl+b"], "command": "build", "args": {
					"build_system": "Packages/User/RunJavaProject.sublime-build"
				}
			},
		]
		```
	+ LSP-jdtls
- Eclipse
	+ Eclipse Color Theme
	+ AmaterasERD
- Oracle SQL Developer