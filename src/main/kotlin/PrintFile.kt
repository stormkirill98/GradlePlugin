import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

const val SKIP_PREFIX = "#skip"

class PrintFilePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("printFile", PrintFileTask::class.java)
    }
}

open class PrintFileTask : DefaultTask() {
    @TaskAction
    fun printFile(filePath: String) {
        val file = File(filePath)

        var countSkipLines = 0
        file.forEachLine { line ->
            if (countSkipLines > 0) { // skip line
                countSkipLines--
            } else {
                val prefix = getStartPrefixValue(line)
                if (prefix == null) { // print line
                    println(line)
                } else { // get skip lines number
                    countSkipLines = getCountSkipLines(prefix)
                }
            }
        }
    }

    private fun getStartPrefixValue(s: String) = Regex("^$SKIP_PREFIX \\d+").find(s)?.value

    private fun getCountSkipLines(s: String) = s.substringAfter(SKIP_PREFIX).trim().toInt()
}
