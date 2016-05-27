<!DOCTYPE>
<html>
<?php

$a[] = "V1";
$a[] = "V2";
$a[] = "V3";
$a[] = "V4";
$a[] = "M1";
$a[] = "M2";
$a[] = "M3";
$a[] = "M4";
$a[] = "F1";
$a[] = "F2";
$a[] = "F3";
$a[] = "F4";


$q = $_REQUEST["q"];
$hint = "";

if ($q !== "") {
    $q = strtolower($q);
    $len = strlen($q);
    foreach($a as $name) {
	if (stristr($q, substr($name, 0, $len))) {

	    if ($hint === "") {
		$hint = $name;
 	    } else {
 		$hint .= ", $name";
	    }
	}
    }
}
echo $hint === "" ? "no suggestion" : $hint;

?>



</html>
