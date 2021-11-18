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
			"working_dir": "$folder",
			"shell_cmd": "javac -d . $file -encoding UTF-8 && java $file_base_name",
			"selector": "source.java",
		}
		```
	+ LSP-jdtls
- Eclipse
	+ Eclipse Color Theme, Eclipse Moonrise UI Theme
- Oracle SQL Developer