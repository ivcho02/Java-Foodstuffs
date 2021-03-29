/**
 * 
 */

window.addEventListener('load', function () {
	var insertForm = document.querySelector("#addFoodstuff");
	var deleteFoodStuffButtons = document.querySelectorAll(".delete__foodstuff-button");
	
	insertForm.addEventListener("submit", function (event) {
		event.preventDefault();
		
		var formData = new FormData(event.target);
		
		fetch('/Foodstuffs/webapi/foodstuffs', {
			method: 'POST',
			body: JSON.stringify(Object.fromEntries(formData)),
			headers: {
				'Content-type': 'application/json; charset=UTF-8'
			}
		}).then(function (response) {
			console.log(response);
		}).then(function (data) {
			console.log(data);
		}).catch(function (error) {
			console.warn(error);
		});
	});
	
	if (deleteFoodStuffButtons) {		
		deleteFoodStuffButtons.forEach(function (deleteButton) {
			deleteButton.addEventListener('click', function (event) {
				var id = event.target.getAttribute('data-id');
				
				fetch('/Foodstuffs/webapi/foodstuffs/' + id, {
					method: 'DELETE',
				}).then(function (response) {
					if (response.ok === true) {
						event.target.parentNode.parentNode.remove();
					}
				}).then(function (data) {
					console.log(data);
				}).catch(function (error) {
					console.warn(error);
				});
			});
		});
	}
});
