import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class PrintFilePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("printFile", PrintFileTask::class.java)
    }
}

open class PrintFileTask : DefaultTask() {
    @TaskAction
    fun printFile() {
        println("Hello World")
    }
}