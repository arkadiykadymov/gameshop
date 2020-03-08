<#import "parts/common.ftlh" as c>

<@c.page>
List of purchases

<table class="table">
    <thead>
    <tr>
        <th scope="col">Purchase date</th>
        <th scope="col">Purchase price</th>
        <th scope="col">Product count</th>
        <th scope="col">User </th>
    </tr>
    </thead>
    <tbody>
    <#list purchases as purchase>
    <tr>
        <td>${purchase.purchase_date}</td>
        <td>${purchase.purchase_price}</td>
        <td>${purchase.products_count}</td>
        <td>${purchase.buyer.username}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>