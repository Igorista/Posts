data  class DocumetAttacmentdata (
    override val type: String,
    val id: Int,
    val docId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment("document") {
}