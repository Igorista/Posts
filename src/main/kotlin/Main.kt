fun main(args: Array<String>) {

    Wallservice.add(Post(0, 12, 22, 32, 81221))
    Wallservice.add(Post(0, 11, 65, 232, 91221))
    Wallservice.update(Post(1, 16, 123, 3435, 101221))
    println(Wallservice.posts.joinToString())
    println(Wallservice.update(post = Post(2,324,234,2345434,34534)))
}

object Wallservice {
    var posts: Array<Post> = emptyArray()
        private set

    fun add(post: Post): Post {
        posts += post
        val notEmpty = posts.last()
        for (i in posts.indices) {
            notEmpty.id = post.id + 1
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var postUpdated = false
        for (i in posts.indices) {
            when {
                posts[i].id != post.id -> {
                    postUpdated = false
                }
                else -> {
                    posts[i].id = post.id
                    posts[i].fromId = post.fromId
                    posts[i].createdBy = post.createdBy
                    postUpdated = true

                }
            }
        }
        return postUpdated
    }
}