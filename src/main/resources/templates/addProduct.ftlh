<#import "parts/common.ftlh" as c>

<@c.page>
<div class="form-group mt-3">
    <form method="post" action="/addProduct" enctype="multipart/form-data">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Insert title" required/>
        </div>
        <div class="form-group">
            <input type="text" name="desc" class="form-control" placeholder="Insert description" required>
        </div>
        <div class="form-group">
            <input type="text" name="price" class="form-control" placeholder="Insert price" required>
        </div>
        <div class="form-group">
            <input type="text" name="count" class="form-control" placeholder="Insert storage count" required>
        </div>
        <div class="form-group">
            <div class="custom-file">
                <input type="file" name="file" id="file">
                <label class="custom-file-label" for="file">Choose file</label>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Add</button>
    </form>
</div>
</@c.page>
