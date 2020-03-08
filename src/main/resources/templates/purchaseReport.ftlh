<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <h5>This is your purchase report</h5>
    <div class="card my-3" style="width: 18rem;">
        <div>
            <#if product.filename??>
            <img class="card-img-top" src="/img/${product.filename}">
        </#if>
    </div>
    <div class="card-body">
        <h5 class="card-title">${product.title}</h5>
        <p class="card-text">${product.description}</p>
        <footer class="blockquote-footer">
            Price: ${product.price}
        </footer>
    </div>
</div>
</@c.page>