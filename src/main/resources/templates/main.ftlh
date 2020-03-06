<#import "parts/common.ftlh" as c>
<#import "parts/log.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<div>Game shop</div>
<#list products as product>
<div>
    <b>${product.id}</b>
    <span>${product.title}</span>
    <span>${product.description}</span>
    <span>${product.price}</span>
    <i>${product.storage_count}</i>
</div>
<#else>
No message
</#list>
</@c.page>