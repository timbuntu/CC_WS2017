# Grammar Defintion

```
SourceFile       = PackageClause { ImportDecl } { TopLevelDecl }
```

## Package Declaration

```
PackageClause  = "package" PackageName .
PackageName    = identifier .
```

## Import Declaration

```
ImportDecl       = "import" ( ImportSpec | "(" { ImportSpec " ;" } ")" ) .
ImportSpec       = [ "." | PackageName ] ImportPath .
ImportPath       = string_lit .
```

## Top Level Declaration

```
TopLevelDecl     = FunctionDecl
TopLevelDecl     = Declaration | FunctionDecl | MethodDecl .
```

## Function Declaration

```
FunctionDecl     = "func" FunctionName
FunctionName     = identifier
```

## Lexical elements

### Identifiers

```
identifier       = "^[A-Za-z][A-Za-z_0-9_]*;*$"
```

### Literals

#### Float Literal

```
float_lit        = "^([0-9]*\\.[0-9]+|[0-9]+\\.[0-9]*);*$"
```

#### Int Literal

```
int_lit          = "^[0-9]+;*$"
```

#### String Literal

```
string_lit       = "^[\"`][^\"']*[\"`];*$"
```

### Operators

```
(    )
[    ]
{    }
,    ;
.    =
+    -
```

### Keywords

```
package_key       = "^package$"
k_import          = "^[Ii]mport$"
k_func            = "^func$"
k_var             = "^var$"
k_const           = "^const$"
```
