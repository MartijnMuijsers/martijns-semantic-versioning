A Gradle plugin that automatically sets a Gradle project according to Semantic Versioning 2.0.0 (https://semver.org/).

The version is determined automatically based on Git tags:
* Commits can have a version Git tag, which has the format of starting with `v` followed by a valid semantic version of the format `MAJOR.MINOR.PATCH`.
* The previous version is based on the latest ancestor commit of the current commit that has a version Git tag. Otherwise, it is assumed to be `0.0.1`.
* The next version is based on the previous version:
  * If at least one commit message since the commit on which the previous version was based starts with `feat:`, or is not formatted like a conventional commit, the next version will be the next major version (e.g. `1.5.4` becomes `2.0.0`)
    * If the major version is `0`, the minor version will be bumped instead (e.g. `0.5.4` becomes `0.6.0`); to bump the major version, a manual `v1.0.0` Git tag should be added to a commit
  * Otherwise, if at least one commit message since the commit on which the previous version was based starts with `fix`, the next version will be the next minor version (e.g. `1.5.4` becomes `1.6.0`)
    * If the major version is `0`, the patch version will be bumped instead (e.g. `0.5.4` becomes `0.5.5`)
  * Otherwise, the next version will be the next patch version (e.g. `1.5.4` becomes `1.5.5`)
* If the current branch is the `main` branch, and there is no Git tag on the current commit, a version Git tag will be added.
* If the current branch is not the `main` branch, `-SNAPSHOT-<normalized branch name>` will be appended to the version, where the branch name is normalized to conform to the pre-release standards of Semantic Versioning 2.0.0.
