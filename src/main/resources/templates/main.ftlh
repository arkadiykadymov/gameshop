<#import "parts/common.ftlh" as c>

<@c.page>
<div>Список товаров</div>

<div class="card-columns">
    <#list products as p>
    <div class="card my-3" style="width: 18rem;">
        <div>
            <#if p.filename??>
            <img class="card-img-top" src="/img/${p.filename}">
            </#if>
        </div>
    <form method="post" action="/buy">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" name="prod_id" value="${p.id}">
        <input type="number" name="count">
        <div class="card-body">
        <h5 class="card-title">${p.title}</h5>
        <p class="card-text">${p.description}</p>
        <button type="submit" class="btn btn-danger">Buy it</button>
        <footer class="blockquote-footer">
            <small>
                Price: ${p.price}
                Storage counter: ${p.storage_count}
            </small>
        </footer>
    </div>
    </form>
</div>
<#else>
No products yet
</#list>
</div>
</@c.page>

