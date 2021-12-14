import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun postExisting() {
        val result: Boolean
        val service = Wallservice
        val attach = Attachments
        attach.attachAdd(VideoAttachment("video",1,1,1,1))
        val videoAdd = attach.attachments
        val add = service.add(Post(0,111,123,12312,123123,videoAdd))
        val(id,_ownerId,_fromId,_createdBy,_date,_attachment) = add
        when {
            id > 0 -> result = true
            else -> result = false
        }
        assertTrue(result)
    }
    @Test
    fun updateExistingTrue(){
        val service = Wallservice
        service.add(Post(0,111,123,12312,123123,null))
        service.add(Post(0,1,112,558,88888,null))
        service.add(Post(0,5551,515,879,797979,null))
        val update = Post(1,5551,611544,445,797979,null)
        val result = service.update(update)
        assertTrue(result)
    }
    @Test
    fun updateExistingFalse() {
        val service = Wallservice
        service.add(Post(0, 111, 123, 12312, 123123,null))
        service.add(Post(0, 1, 112, 558, 88888,null))
        service.add(Post(0, 5551, 515, 879, 797979,null))
        val update = Post(5, 1616, 611544, 445, 44444,null)
        val result = service.update(update)
        assertFalse(result)
    }
}