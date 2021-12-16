data  class AudioAttachment(
    override val type: String,
    val audio: Audio
) : Attachment("audio") {
}