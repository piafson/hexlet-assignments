@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page
<!-- BEGIN -->
@template.layout.page(
content = @`

    <h1>Posts</h1>
    <table class="table table-striped">
        @for(var post : page.getPosts())
            <tr>
                <td>
                    ${post.getId()}
                </td>
                <td>
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </td>
            </tr>
        @endfor
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="?page=${page.getPageNumber() < 2 ? 1 : page.getPageNumber() - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPageNumber()}">${page.getPageNumber()}</a></li>
            <li class="page-item">
                <a class="page-link" href="?page=${page.getPageNumber() + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
`
)
<!-- END -->
