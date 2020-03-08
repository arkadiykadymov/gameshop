<#import "parts/common.ftlh" as c>
<#import "parts/log.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>
    <form method="post" action="/addProduct" enctype="multipart/form-data">
        <input type="text" name="title" placeholder="Введите название товара" />
        <input type="text" name="desc" placeholder="Введите описание товара">
        <input type="text" name="price" placeholder="Введите цену">
        <input type="text" name="count" placeholder="Введите число">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список товаров</div>
<#list products as p>
<div>
    <span>${p.title}</span>
    <i>${p.description}</i>
    <strong>${p.price}</strong>
    <strong>${p.storage_count}</strong>
    <div>
        <#if p.filename??>
            <img src="/img/${p.filename}">
        </#if>
    </div>
</div>
<#else>
No products yet
</#list>
</@c.page>

