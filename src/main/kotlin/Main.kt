fun main(args: Array<String>) {
    Attachments.attachAdd(VideoAttachment("video",21,12,1,12))
    Attachments.attachAdd(AudioAttachment("audio",1,2,3,4))
    Attachments.attachAdd(LinkAttachment("link",2,2,2,2))
    var attach1 = Attachments.attachments
    Wallservice.add(Post(0, 12, 22, 32, 81221, attach1))
    Wallservice.add(Post(0, 11, 65, 232, 91221,null))
    Attachments.attachAdd(LinkAttachment("link",3,3,3,3))
    attach1 = Attachments.attachments
    Wallservice.update(Post(1, 16, 123, 3435, 101221,attach1))
    println(Wallservice.posts.joinToString())

}

object Wallservice {
    var posts: Array<Post> = emptyArray()
        private set

    fun add(post: Post): Post {
        posts += post
        val notEmpty = posts.last()
        notEmpty.id = posts.size.toLong()
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var postUpdated = false
        for (i in posts.indices) {
            when {
                posts[i].id != post.id -> {
                }
                else -> {
                    posts[i].id = post.id
                    posts[i].fromId = post.fromId
                    posts[i].createdBy = post.createdBy
                    posts[i].attachment = post.attachment
                    postUpdated = true

                }
            }
        }
        return postUpdated
    }
}
object Attachments{
    var attachments: Array<Attachment> = emptyArray()
    private set

    fun attachAdd (attachment: Attachment): Attachment {
        attachments += attachment
        return attachments.last()
    }

}