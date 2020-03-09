<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
<h1 style="color:rgb(255,0,0)">
    ${errorMessage?ifExists}
</h1>

<h2>Products</h2>

<div class="card-columns">
    <#list products as p>
    <div class="card my-3" style="width: 18rem;">
        <div>
            <#if p.filename??>
            <img class="card-img-top" src="/img/${p.filename}">
        </#if>
    </div>
    <div class="card-body">
        <h5 class="card-title">${p.title}</h5>
        <p class="card-text">${p.description}</p>
        <form method="post" action="/buy">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <input type="hidden" name="prod_id" value="${p.id}">
            <input type="number" name="count" required>
            <button type="submit" class="btn btn-danger">Buy it</button>
        </form>
        <#if isAdmin>
        <form method="post" action="/delete">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <input type="hidden" name="prod_id" value="${p.id}">
            <button type="submit" class="btn btn-danger">Delete it</button>
        </form>
        <a href="/edit/${p.id}">Edit</a>
        </#if>
        <footer class="blockquote-footer">
            <small>
                Price: ${p.price}
                Storage counter: ${p.storage_count}
            </small>
        </footer>
    </div>
</div>
<#else>
No products yet
</#list>
</div>
</@c.page>

