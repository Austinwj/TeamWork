<html>

<head>
	<!-- Web page title -->
	<title>Top Trumps</title>

	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

	<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

	<style>
		* {
			margin: 0;
			padding: 0;
		}
	</style>

</head>

<body onload="initalize()"> <!-- Call the initalize method when the page loads -->

<!-- Add your HTML Here -->
<div class="container">

	<div style="background-color: #363636; height: 30px; width: 100%; text-align: center">
		<p style="color: white; font-weight: bold; font-size: 19px; line-height: 30px;">
			Top Trumps
		</p>
	</div>

	<div style="background-color:palevioletred; width: 50%; text-align: center; margin-left: 25%;">
		<a href="http://localhost:7777/toptrumps/game">
            <span style="height: 30px;line-height: 30px; color: white">
                >> New Game <<
            </span>
		</a>
	</div>

	<div style="background-color:yellow; width: 50%; text-align: center; margin-left: 25%;">
		<a href="http://localhost:7777/toptrumps/stats">
            <span style="height: 30px;line-height: 30px; color: black">
                >> Game Statistics <<
            </span>
		</a>
	</div>

</div>


<script type="text/javascript">

	// Method that is called on page load
	function initalize() {

		// --------------------------------------------------------------------------
		// You can call other methods you want to run when the page first loads here
		// --------------------------------------------------------------------------

		// For example, lets call our sample methods

	}

	// -----------------------------------------
	// Add your other Javascript methods Here
	// -----------------------------------------
	function newGame() {
		var num = prompt("Enter the number of AI player:");
		if (num == null){
			window.opener.location.reload();
		}
		else if (num >= "1" && num <= "4") {
			window.location.href = "http://localhost:7777/toptrumps/game?p=" + num;
		} else if (num < "1"){
			alert("At least one AI player!")
		}
		else if (num > "4"){
			alert("Most 4 players!");
		}
	}



	// This is a reusable method for creating a CORS request. Do not edit this.
	function createCORSRequest(method, url) {
		var xhr = new XMLHttpRequest();
		if ("withCredentials" in xhr) {

			// Check if the XMLHttpRequest object has a "withCredentials" property.
			// "withCredentials" only exists on XMLHTTPRequest2 objects.
			xhr.open(method, url, true);

		} else if (typeof XDomainRequest != "undefined") {

			// Otherwise, check if XDomainRequest.
			// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
			xhr = new XDomainRequest();
			xhr.open(method, url);

		} else {

			// Otherwise, CORS is not supported by the browser.
			xhr = null;

		}
		return xhr;
	}

</script>


</body>
</html>