#!/bin/bash
DIR=test_resources

files=`ls $DIR`
BIN=calc++

function assert_fail {
    file="$1"
    output=`./calc++ "$file" 2>&1`
    result=$?
    if [ $result -eq 0 ];then
            echo Testing file $file passed, but I expected it to fail.
            echo $output
            return 1
    else
            return 0
    fi

}

function assert_not_fail {
    file="$1"
    output=`./$BIN "$DIR/$file" 2>&1`
    result=$?
    if [ $result -ne 0 ];then
            echo Testing file $file failed, but I expected it to pass.
            echo $output
            return 0
    else
            return 1
    fi

}

echo running tests...
echo `echo "$files" | wc -l` tests found

echo "$files" | while read file; do
    echo testing file $file
    if echo "$file" | grep bad > /dev/null; then
            assert_fail "$file"
    else
            assert_not_fail "$file"
    fi
done
