# CC_WS2017


To build this project use "ant default"

Or import CC_P1`into netbeans an run clean build`.

Test files are located under `CC_P1/test/resources`.
```
$ ls CC_P1/test/resources
bad_import_2.go
bad_import_3.go
bad_import_4.go
bad_import_5.go
bad_package.go
good_func_decl.go
good_import.go
good_import_package.go
good_import_punctation.go
good_package.go
lexer_bad_import.go
lexer_good_import.go
```

To run this program use `java -jar "./CC_P1/dist/CC_P1.jar" CC_P1/test/resources/good_func_decl.go`
