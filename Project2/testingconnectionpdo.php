<?php
$servername = "localhost:3306/";
$username = "danielhan";
$password = "12041992";
$database = "inf124grp31";
// Create connection
try {
    $conn = new PDO("mysql:host=$servername;dbname=cs137", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo "Connected successfully"; 
    }
catch(PDOException $e)
    {
    echo "Connection failed: " . $e->getMessage();
    }




?>