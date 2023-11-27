@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="input-group mb-3">
            <label>
                Название статьи
                <input type="text" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Текст статьи
                <p><textarea name="content">${page.getContent()}</textarea></p>
            </label>
        </div>

    </form>
`
)
