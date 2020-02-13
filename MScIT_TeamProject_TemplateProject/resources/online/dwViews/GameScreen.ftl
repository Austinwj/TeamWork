<html>

<head>
    <!-- Web page title -->
    <title>Top Trumps</title>

    <!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

<body onload="initalize()">

<div class="container">


    <div style="background-color: #363636; height: 30px; width: 100%; text-align: center">
        <p style="color: white; font-weight: bold; font-size: 19px; line-height: 30px;">
            Top Trumps
        </p>
    </div>


    <div style="height: 20px; width: 10%; margin-top: 20px;">
        <div style="float: left; color: black; font-weight: bold; font-size: 10px; line-height: 20px;">
            Choose a property:
        </div>

    </div>

    <a href="javascript:void(0);" onclick="choose(0)">
        <div style="background-color: #363636; height: 20px; width: 10%; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                Size:
            </div>

            <div id="pSize"
                 style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 20px; line-height: 20px;">
                test
            </div>
        </div>
    </a>

    <a href="javascript:void(0);" onclick="choose(1)">
        <div style="background-color: #363636; height: 20px; width: 10%; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                Speed:
            </div>

            <div id="pSpeed"
                 style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 20px; line-height: 20px;">
                test
            </div>
        </div>
    </a>

    <a href="javascript:void(0);" onclick="choose(2)">
        <div style="background-color: #363636; height: 20px; width: 10%; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                Range:
            </div>

            <div id="pRange"
                 style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 20px; line-height: 20px;">
                test
            </div>
        </div>
    </a>

    <a href="javascript:void(0);" onclick="choose(3)">
        <div style="background-color: #363636; height: 20px; width: 10%; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                Firepower:
            </div>

            <div id="pFirepower"
                 style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                test
            </div>
        </div>
    </a>

    <a href="javascript:void(0);" onclick="choose(4)">
        <div style="background-color: #363636; height: 20px; width: 10%; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 10px; line-height: 20px;">
                Cargo:
            </div>

            <div id="pCargo"
                 style="float: left; color: white; font-weight: bold; font-size: 10px; margin-left: 20px; line-height: 20px;">
                test
            </div>
        </div>
    </a>

</div>

<script type="text/javascript">


    // Method that is called on page load
    function initalize() {
        // --------------------------------------------------------------------------
        // You can call other methods you want to run when the page first loads here
        // --------------------------------------------------------------------------
        reset();
        addPlayer();
        drawCard();
        sendCard();

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

<script type="text/javascript">

    // -----------------------------------------
    // Add your other Javascript methods Here
    // -----------------------------------------

    var  aiNum = undefined;

    // Add AI function
    // This calls the helloJSONList REST method from TopTrumpsRESTAPI
    function addPlayer() {
        aiNum = location.search.split("=")[1];
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/addPlayer?Number=" + aiNum); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function drawCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/drawCard"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function choose(num) {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/choose?Number=" + num); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        removeCard();
        sendCard();
        xhr.send();

    }

    function sendCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/sendCard");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            var card = jQuery.parseJSON(responseText);
            document.getElementById("pSize").innerHTML = card.size;
            document.getElementById("pSpeed").innerHTML = card.speed;
            document.getElementById("pRange").innerHTML = card.range;
            document.getElementById("pFirepower").innerHTML = card.firepower;
            document.getElementById("pCargo").innerHTML = card.cargo;
        };
        xhr.send();
    }

    function removeCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/removeCard"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function reset() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/reset"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }



</script>

</body>
</html>