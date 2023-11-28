@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes;
@param PostPage page
<!-- BEGIN -->
@template.layout.page(
content = @`
    <a href="${NamedRoutes.postsPath()}">Все посты</a>
    <div class="mx-auto p-4 py-md-5">
        <h1>${page.getPost().getName()}</h1>
    </div>

    <div class="mx-auto p-4 py-md-5">
        ${page.getPost().getBody()}
    </div>
`
)
<!-- END -->
