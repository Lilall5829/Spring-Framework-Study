# Spring-Framework-Study
**This is my note on studying Java Spring Boot**
## Note 1004

## Note 1005

## Note 1008
`git commit -am "commit message"` is the shortcut of commit + add but only for modifying file, not for creating a new file.

How to make a branch? Such as a branch named "feature-1"? 
Use `git checkout` to switch between the different branches.
Use `git diff (branch name)` to show the different branches' differences.
Use `git merge (branch name)` to merge the branch to the master branch.
Use `git reset (optional: file name or commit hash value (get from git log))` to undo your operation.
```
git status
git branch
git checkout -b feature-1
get branch
git checkout master
git diff feature-1
git push -u origin feature-1
git checkout feature-1
git merge
...(make some change in feature-1)
git checkout master
git pull
git branch -d feature-1 //delete feature-1

git reset --hard hash value

```


