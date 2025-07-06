package nl.martijnmuijsers.martijnssemanticversioning

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersioningPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // no-op for now
        project.logger.lifecycle("VersioningPlugin applied!")
    }
}