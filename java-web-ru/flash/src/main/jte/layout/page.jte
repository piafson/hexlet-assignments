@import gg.jte.Content
@import exercise.dto.BasePage
@param Content content
@param BasePage page = null
<!-- BEGIN -->
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<main>
    @if(page != null && page.getFlash() != null)
        <div class="alert alert-dismissible alert-success" role="alert">
            <p>${page.getFlash()}</p>
            <button type="button" class="btn-close fade show" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    @endif
    <div>
        ${content}
    </div>
</main>
</body>
</html>
<!-- END -->
