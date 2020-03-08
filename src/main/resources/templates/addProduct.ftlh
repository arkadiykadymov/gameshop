<#import "parts/common.ftlh" as c>

<@c.page>
<div class="form-group mt-3">
    <form method="post" action="/addProduct" enctype="multipart/form-data">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Введите название товара"/>
        </div>
        <div class="form-group">
            <input type="text" name="desc" class="form-control" placeholder="Введите описание товара">
        </div>
        <div class="form-group">
            <input type="text" name="price" class="form-control" placeholder="Введите цену">
        </div>
        <div class="form-group">
            <input type="text" name="count" class="form-control" placeholder="Введите число">
        </div>
        <div class="form-group">
            <div class="custom-file">
                <input type="file" name="file" id="file">
                <label class="custom-file-label" for="file">Choose file</label>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
</@c.page>


<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="text" placeholder="Введите сообщение"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="tag" placeholder="Тэг">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>