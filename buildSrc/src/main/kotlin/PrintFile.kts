open class PrintFileExtension {
    var filePath: String? = null
}

class PrintFilePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<PrintFileExtension>("printFileExtension")
        project.task("printFile") {
            doLast {
                println(extension.filePath)
            }
        }
    }
}