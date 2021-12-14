data  class AudioAttachment(
    override val type: String,
    val id: Int,
    val audioId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment("audio") {
}