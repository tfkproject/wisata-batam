<?php
// array for JSON response
$response = array();
// include db connect class
require 'connection.php';
$keyword = $_GET['q'];
if($result = $db->query("SELECT * FROM tbl_wisata where nama_objek like '%$keyword%'")){
    	if($count = $result->num_rows){
    		$response["field"] = array();
    		
    		while($row = $result->fetch_object()){
    			$data = array();
    			$data["id_wisata"] = $row->id_wisata;
    			$data["nama_objek"] = $row->nama_objek;
    			$data["foto_cover"] = "http://203.153.21.11/app/wisata-batam/images/wisata/".$row->foto_cover;
    			$data["lokasi"] = $row->lokasi;
    			$data["deskripsi"] = $row->deskripsi;
    			$data["latitude"] = $row->latitude;
    			$data["longitude"] = $row->longitude;
    			
    			array_push($response["field"], $data);
    		}
    		
    		$response["success"] = 1;
    		
    		// echoing JSON response
    		echo json_encode($response);
    	}
    	else{
    	    // no datas found
            $response["success"] = 0;
            $response["message"] = "Maaf, data tidak ada";
            // echo no users JSON
            echo json_encode($response);
    	}
    		
    		$result->free();
    }
    else {
        // no datas found
        $response["success"] = 0;
        $response["message"] = "Maaf, terdapat error pada database";
        // echo no users JSON
        echo json_encode($response);
    }
?>
