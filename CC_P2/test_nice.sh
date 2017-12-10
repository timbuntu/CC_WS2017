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
            return 1
    else
            return 0
    fi

}

echo running tests...
echo `echo "$files" | wc -l` tests found

export stat_passed=0
export stat_failed=0
for file in `echo "$files"`; do
    echo testing file $file
    if echo "$file" | grep bad > /dev/null; then
            assert_fail "$file"
    else
            assert_not_fail "$file"
    fi

    result=$?
    if [ $result -eq 0 ]; then
            stat_passed=$(($stat_passed + 1))
    else
            stat_failed=$(($stat_failed + 1))
    fi
done

echo ">> $stat_passed Tests passed. $stat_failed Tests failed"
if [ $stat_failed -gt 0 ]; then
        exit 1
else
        exit 0
fi
