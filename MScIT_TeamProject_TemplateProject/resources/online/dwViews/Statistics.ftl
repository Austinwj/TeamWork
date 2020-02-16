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

</head>

<body onload="initalize()"> <!-- Call the initalize method when the page loads -->

<div class="container">

	<div class="header" style="background-color: #363636; height: 30px; width: 100%; text-align: center">
		<p style="color: white; font-weight: bold; font-size: 19px; line-height: 30px;">
			Top Trumps
		</p>
	</div>

	<div class="sub-header" style="margin-top: 20px">

		<a href="http://localhost:7777/toptrumps/game">
			<div style="float: left; background-color: #363636; height: 20px; width: 30%; text-align: center; margin-left: 100px">
				<div style="color: white; font-weight: bold; font-size: 15px; line-height: 20px;">
					Start a New Game
				</div>

			</div>
		</a>


		<a href="http://localhost:7777/toptrumps/">
			<div style="float: right; background-color: #363636; height: 20px; width: 30%; margin-left: 50px; text-align: center; margin-right: 100px">
				<div style="color: white; font-weight: bold; font-size: 15px; line-height: 20px;">
					Exit Game
				</div>

			</div>
		</a>

	</div>

	<div id="Game Statistics" style="float: left; margin-left: 25%; margin-top: 20px; width: 50%; ">


		<div style=" height: 40px; margin-top: 30px">
			<div style="float: left; color: black; font-weight: bold; font-size: 30px; margin-left: 10px; line-height: 20px;">
				Number of Games:
			</div>

			<div id="NumOfGames"
				 style="background-color: #363636; float: right; color: white; font-weight: bold; font-size: 20px; margin-right: 30px; line-height: 25px; width: 20%; text-align: center">
				0
			</div>
		</div>

		<div style=" height: 40px; margin-top: 30px">
			<div style="float: left; color: black; font-weight: bold; font-size: 30px; margin-left: 10px; line-height: 20px;">
				Number of AI Wins:
			</div>

			<div id="NumOfAIWins"
				 style="background-color: #363636; float: right; color: white; font-weight: bold; font-size: 20px; margin-right: 30px; line-height: 25px; width: 20%; text-align: center">
				0
			</div>
		</div>

		<div style=" height: 40px; margin-top: 30px">
			<div style="float: left; color: black; font-weight: bold; font-size: 30px; margin-left: 10px; line-height: 20px;">
				Number of User Wins:
			</div>

			<div id="NumOfUserWins"
				 style="background-color: #363636; float: right; color: white; font-weight: bold; font-size: 20px; margin-right: 30px; line-height: 25px; width: 20%; text-align: center">
				0
			</div>
		</div>

		<div style=" height: 40px; margin-top: 30px">
			<div style="float: left; color: black; font-weight: bold; font-size: 30px; margin-left: 10px; line-height: 20px;">
				Average number of Draws:
			</div>

			<div id="AvgNumOfDraws"
				 style="background-color: #363636; float: right; color: white; font-weight: bold; font-size: 20px; margin-right: 30px; line-height: 25px; width: 20%; text-align: center">
				0
			</div>
		</div>

		<div style=" height: 40px; margin-top: 30px">
			<div style="float: left; color: black; font-weight: bold; font-size: 30px; margin-left: 10px; line-height: 20px;">
				Longest Game:
			</div>

			<div id="LongestGame"
				 style="background-color: #363636; float: right; color: white; font-weight: bold; font-size: 20px; margin-right: 30px; line-height: 25px; width: 20%; text-align: center">
				0
			</div>
		</div>

		<div style=" height: 40px; margin-top: 30px; text-align: center">
			<div style="color: black; font-weight: bold; font-size: 20px;line-height: 20px; text-align: center">
				If statistics not update, please refresh!
			</div>
		</div>


	</div>

</div>

<script type="text/javascript">

	// Method that is called on page load
	function initalize() {

		showGameStatistics();
	}

	// -----------------------------------------
	// Add your other Javascript methods Here
	// -----------------------------------------


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

<!-- Here are examples of how to call REST API Methods -->
<script type="text/javascript">

	function showGameStatistics() {
		var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/showGameStatistics"); // Request type and URL
		if (!xhr) {
			alert("CORS not supported");
		}
		xhr.onload = function (e) {
			var responseText = xhr.response;
			var statisticsList = jQuery.parseJSON(responseText);
			$('#NumOfGames').html(statisticsList[0]);
			$('#NumOfAIWins').html(statisticsList[1]);
			$('#NumOfUserWins').html(statisticsList[2]);
			$('#AvgNumOfDraws').html(statisticsList[3]);
			$('#LongestGame').html(statisticsList[4]);

		};
		xhr.send();
	}

</script>

</body>
</html>