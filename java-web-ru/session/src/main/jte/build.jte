@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page = new exercise.dto.LoginPage(null, null)

<!-- BEGIN -->
@template.layout.page(
content = @`
    @if(page.getName() != null)
        <p>${page.getError()}</p>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            Имя
            <input type="text" name="name" placeholder="Имя" value="${page.getName()}">
        </label>
        <label>
            Пароль
            <input type="password" name="password" placeholder="Пароль">
        </label>
            <input type="submit" value="Войти">
    </form>
    `
)
<!-- END -->
