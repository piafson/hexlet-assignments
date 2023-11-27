@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div class="input-group mb-3">
            <label>
                Имя
                <input type="text" name="firstName" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Фамилия
                <input type="text" name="lastName" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Email
                <input type="email" required name="email" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)
