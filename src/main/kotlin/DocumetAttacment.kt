data  class DocumetAttacmentdata (
    override val type: String,
    val doc: Document
) : Attachment("document") {
}