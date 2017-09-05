$(function(){
	

	// ===================================================================================================================================
	// Home page caroussel (index.htm)
	// ===================================================================================================================================
	
	var slider = $('#slider').slider({
		animtype    : 'fade',
		width       : 435,
		height      : 290,
		speed       : 500,
		delay       : 5000,
		starting	: onSlideStart,
		complete	: onSlideFinish
	});

	function onSlideStart(ctx){
		ctx.find("figcaption").fadeOut('fast');
	}
	function onSlideFinish(ctx){
		ctx.find("figcaption").hide().fadeIn();
	}
	$('.arrow').on('click', function(event) {
		event .preventDefault();

		$('#slider').find("figcaption").fadeOut(100);

		var fn = this.className.split(' ')[1];
		//console.log(fn);

		slider.data('slider')[fn]();
	});

	

	// ===================================================================================================================================
	// INTRANET login (all pages)
	// ===================================================================================================================================
	
	$("#intranet").on('click', function(event){
		$("#login-panel").slideToggle();
	});
	$("#forgot-pass-link").on('click', function(event){
		event.preventDefault();
		$(this).parent().slideUp();
		$(this).parent().next().slideDown();
	});
	$("#btn-close").on('click', function(event){
		event.preventDefault();
		$(this).parent().slideUp();
		$(this).parent().prev().slideDown();
	});



	// ===================================================================================================================================
	// Collapsible pannels (ex: tarifs.htm)
	// ===================================================================================================================================

	function openPanel(elem){
		$(elem)
			.stop()                             // stop the margin animation (header)
			.addClass("open")                   // add class open (turn the arrow down)
			.css("margin-bottom", "10px")       // reset the default margin
			.next(".panel").stop().slideDown(function(){ // find the panel element and slide it down
												$(this).css('zoom', 1); // stupid hack for IE to deal with disappearing content
											});
	}
	function closePanel(elem){
		$(elem)
			.removeClass("open")                // remove the open class for all the <header>
			.next(".panel").slideUp(400)        // closse all the panels
				.prev("header").animate({'margin-bottom': 0 }, 400); // find the respectives <header> tags and animate/remove de margin-bottom
	}


	// DOM manipulation

	// 1. Wrap the content of <article> tag's into a wrapper ".panel"
	$(".accordion .accordion-panel").wrapInner('<div class="panel">')
	
	// 2. Move the <header> outside de wrapper
	.find("header").each(function(){
		$(this).prependTo($(this).parent().parent());
	})
	// 3. Apply the accordion fx to all the headers inside the panels with the class '.accordion-panel'
	.on('click', function(){

		if ($(this).hasClass("open"))
		{
			// close the panel if it panel was already open
			closePanel(this);
		}
		else
		{
			// close all panels
			closePanel(".accordion .accordion-panel header")

			// open the panel that was clicked
			openPanel(this);
		}

	})

	// 4. Move the intro block outside de wrapper (before the <header>)
	.find(".intro").each(function(){
		$(this).prependTo($(this).parent().parent());
	});

	// 5. Hide all the panel
	$(".panel").hide()

	// 6. Open the panel that contain an header with a class '.open'
	openPanel(".accordion .accordion-panel header.open")


	
	// ===================================================================================================================================
	// Timeline (certisys-history.htm)
	// ===================================================================================================================================
	
	$(".timeline").each(function(){

		var margin      = 20;
		var navWidth    = $(this).width() - (margin * 2);

		$(this).find('> li').each(function(){

			var liRoot      = $(this);
			var numItms     = $(this).find(".timeline-nav li").length;
			var closeDist   = navWidth / numItms;
			var OPENWIDTH   = 65;

			$(this).find(".timeline-nav li").each(function(i){
				$(this)
				.css({
					"position"  : "absolute",
					"top"       : 0,
					"left"      : (closeDist * i) + (margin/2) + "px",
					"z-index"   : numItms - i
				})
				.data("zindex", numItms - i)
				.on("mouseenter", function(){
					$(this).css("z-index", 1000).addClass("over");
				})
				.on("mouseleave", function(){
					$(this).css("z-index", $(this).data("zindex")).removeClass("over");
				})
				.on("click", function(){
					$(this).parent().find(".selected").removeClass("selected");
					$(this).addClass("selected");

					liRoot.find("article").hide();
					liRoot.find("#" + $(this).text()).show();
					liRoot.find("h2").text( $(this).text() );

					var clicked = $(this).index();

					if (clicked == 0 || clicked == numItms-1){
						openWidth = OPENWIDTH/2;
						openDist = (navWidth - openWidth) / numItms;
					}
					else{
						openWidth = OPENWIDTH;
						openDist = (navWidth - openWidth) / numItms;
					}


					liRoot.find(".timeline-nav li").each(function(i){
						var pos = ( i <= clicked ) ? (openDist * i) : (openDist * i) + openWidth;

						if (clicked == i && clicked > 0) pos += OPENWIDTH/2;

						$(this).animate({
							left: pos + (margin/2) + "px"
						  }, 300 );
					});

				});

			})
			
			$(this).find("article").hide().first().show();
		});

		
	});

	// ===================================================================================================================================
	// Bio starting steps (commencer-en-bio.htm)
	// ===================================================================================================================================
	
	$("#bio-start-steps")
	.find('li')
		.on('click', function(){

			var _this = $(this);

			// Sinds $(this).index() return wrong values under IE
			// we use the tabindex attribute instead
			var i = $(this).attr('tabindex') - 1;

			_this.parent().find('li').each(
				function(){ $(this).removeClass("selected")
			});
			_this.addClass("selected");

			// COLLAPSE VERSION
			// $("#bio-start-steps").find("div:visible").slideUp(300, function(){
			// 	$("#bio-start-steps").find("div:eq( " + i + ")").slideDown();
			// });
			
			$("#bio-start-steps").find("div:visible").hide();
			$("#bio-start-steps").find("div:eq( " + i + ")").show();
			
		})

	$("#bio-start-steps").find("div").hide().first().show();



	// ===================================================================================================================================
	// Labeling info (labeling.htm)
	// ===================================================================================================================================

	$('.labeling .hotspot')
	.on('mouseenter', function(){
		var pos = $(this).position();
		var decal = $(this).hasClass("h") ? [10, 25] : [25, 10];
		$(this).next()
			.css({
				"top": pos.top + decal[0],
				"left": pos.left + decal[1]
			})
			.fadeIn('fast');
	})
	.on('mouseleave', function(){
		$('.hotspot').next().fadeOut('fast');
	})



	// ===================================================================================================================================
	// Google map image alternative for IE (display problems whith more than 1 map)
	// ===================================================================================================================================

	if (navigator.appName == 'Microsoft Internet Explorer'){
		$("#map-bolinne").html('<a href="http://goo.gl/maps/nlmjW" target="_blank"><img src="img/map-bolinne.jpg" alt="Certisys - Gand" width="465" height="350"></a>');
		$("#map-gand").html('<a href="http://goo.gl/maps/HacPA" target="_blank"><img src="img/map-gand.jpg" alt="Certisys - Gand" width="465" height="350"></a>');
	}

});







