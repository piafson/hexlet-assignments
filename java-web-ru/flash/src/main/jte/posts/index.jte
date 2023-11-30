@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@param PostsPage page
<!-- BEGIN -->
@template.layout.page(
content = @`
    <div>
        <table>
            <tr>
                @for(Post post : page.getPosts())
                    <td>${post.getName()}</td>
                @endfor
            </tr>
        </table>
    </div>
`
)
<!-- END -->
