<%-- 
    Document   : index
    Created on : May 27, 2016, 2:59:32 AM
    Author     : Sharon
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>
<%@page import="java.util.ArrayList, javax.servlet.http.*" %>
<%
    HttpSession sessiona = request.getSession(false);
    if(sessiona.getAttribute("last")==null){
        ArrayList last = new ArrayList();
        sessiona.setAttribute("last", last);
    } else {
        ArrayList last = (ArrayList)sessiona.getAttribute("last");
    }
%>
 
<!DOCTYPE html>
<html>
    <head>
        <style>
            @font-face { font-family: Moon Flower; src: url('Moon Flower.ttf'); }
            @font-face { font-family: Moon Flower; font-weight: bold; src: url('Moon Flower Bold.ttf');}

            div{ width: 50%; height: 100%; float: left;text-align: center; font-size: 33px;font-weight: bold;}
            table {
                    /*border: 1px solid blue;*/
                    font-family: "Verdana";
                    border-spacing: 2em;
            }
            td {
                    /*border: 1px solid green;*/
                    text-align: center;
                    width: 500px;
            }
            p {
                    margin: 0;
            }
            img.table {
                    border: 3px solid black;
                    width: 250px;
                    height: 250px;
            }
            img.table:hover{ 
                    width: 400px;
                    height: 400px;
            }
            #img1 {
                    margin-right: auto;
                    margin-left: auto;
                    display: block;
                    max-width: 100%;
                    width: auto;
                    height: auto;
                    text-align: center;
            }
            #link {
                    font-family: Moon Flower;
                    color: gray;
                    text-decoration: none;
                    font-size: 80px;
            }
            .category {
                    font-size:2em;
            }
            /*
            body{
                    background: rgba(242,246,248,1);
            }*/
        </style>

        <script type="text/javascript">

        </script>

        <br></br>
        <img id = "img1" src="banner.jpg">
        <!--<img id="img1" src="http://www.progressivegrocer.com/sites/default/files/styles/article-full/public/PG%20Articles/Fresh%20Foods_0.jpg?itok=bm6ELlOG" >-->
        <br></br>
        <!--<div><a href="MainPage.html"><img src="home.png", height="100px"></a></div>
        <div><a href="AboutUs.html"><img src="aboutus.png", height="100px"></a></div>-->
        <div><a href="index.html", id="link">Home</a></div>
        <div><a href="AboutUs.html", id="link">About Us</a></div>
        <br></br>
    </head>
    <body>
        </br>
        <p>
            <table align="center">
                <tr>
                    <td class="category">Meats</td>   <!--in every table row, there are different table data cells-->
                    <td class="category">Vegetables</td>
                    <td class="category">Fruits</td>
                </tr>
                <tr>
                    <td><a href="Product?pid=m1" name="m1"><img class="table" src="http://www.seriouseats.com/images/2015/04/20150408-canadian-bacon-taste-test.jpg" alt="Bacon"/></a><p>$50.00</p><p>Canadian Bacon</p></td>
                    <td><a href="Product?pid=v1" name="v1"><img class="table" src="https://dbjpq4m8xws63.cloudfront.net/gallery/article/136129-2669" alt="Baby Carrots"/></a><p>$5.00</p><p>Baby Carrots</p></td>
                    <td><a href="Product?pid=f1" name="f1"><img class="table" src="http://www.followingthenerd.com/site/wp-content/uploads/apple1.jpg" alt="Apple"/></a><p>$9.00</p><p>Apples</p></td>
                </tr>

                <tr>
                    <td><a href="Product?pid=m2"><img class="table" src="http://www.glatt-organics.com/wp-content/uploads/2013/08/iStock_000010753409Large.jpg" alt="Chicken Breast"/></a><p>$30.00</p><p>Chicken Breast</p></td>
                    <td><a href="Product?pid=v2"><img class="table" src="http://www.specialtyproduce.com/sppics/581.png" alt="Romaine Lettuce"/></a><p>$10.00</p><p>Romaine Lettuce</p></td>
                    <td><a href="Product?pid=f2"><img class="table" src="http://dreamatico.com/data_images/banana/banana-3.jpg" alt="Banana"/></a><p>$1.00</p><p>Bananas</p></td>
                </tr>

                <tr>
                    <td><a href="Product?pid=m3"><img class="table" src="http://cdn1.bigcommerce.com/n-ww20x/uvsd1rv/products/80/images/280/Ribeye_Steak__19258.1385953288.1280.1280.jpg?c=2" alt="Rib Eye Steak"/></a><p>$70.00</p><p>Rib Eye Steak</p></td>
                    <td><a href="Product?pid=v3"><img class="table" src="http://www.kontrolmag.com/wp-content/uploads/2015/05/Spinach.jpg" alt="Spinach"/></a></p>$33.00</p><p>Spinach</p></td>
                    <td><a href="Product?pid=f3"><img class="table" src="https://upload.wikimedia.org/wikipedia/commons/4/43/Pitaya_cross_section_ed2.jpg" alt="Dragonfruit"/></a></p>$44.00</p><p>Dragonfruit</p></td>
                </tr>

                <tr>
                    <td><a href="Product?pid=m4"><img class="table" src="http://sushistik.com.ua/image/data/Salmon.png" alt="Salmon"/></a><p>$100.00</p><p>Salmon</p></td>
                    <td><a href="Product?pid=v4"><img class="table" src="http://www.legacygreens.com/wp-content/uploads/2016/03/Yellow-onion.jpg" alt="Yellow Onion"/></a><p>$12.00</p><p>Yellow Onions</p></td>
                    <td><a href="Product?pid=f4"><img class="table" src="https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg" alt="Oranges"/></a><p>$17.00</p><p>Oranges</p></td>
                </tr>
            </table>
        </p>
        </br>
        </br>
        <h2>Last 5 Viewed Products: </h2>
        <c: forEach items="${last}" var="item">
            <tr>
                <td><c:out value="${item}" /></td>
            </tr>
        </c:forEach>
        
    </body>
</html>
