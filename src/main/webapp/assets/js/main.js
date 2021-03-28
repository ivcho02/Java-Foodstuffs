/**
 * 
 */

window.addEventListener('load', function () {
	var insertForm = document.querySelector("#addFoodstuff");
	
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
});
