/**
 * 
 */

window.addEventListener('load', function () {
	var foodStuffForm = document.querySelector("#foodStuffForm");
	var deleteFoodStuffButtons = document.querySelectorAll(".delete__foodstuff-button");
	
	if (foodStuffForm) {		
		foodStuffForm.addEventListener("submit", function (event) {
			event.preventDefault();
			
			var form = event.target;
			var formData = new FormData(form);
			var httpMethod = form.getAttribute("data-method");
			
			if (httpMethod === "PUT") {
				var editId = form.getAttribute("data-id");
				
				formData.append("id", editId)
			}
			
			fetch('/Foodstuffs/webapi/foodstuffs', {
				method: httpMethod,
				body: JSON.stringify(Object.fromEntries(formData)),
				headers: {
					'Content-type': 'application/json; charset=UTF-8'
				}
			}).then(function (response) {
				if (response.ok) {
					window.location.href = "/Foodstuffs/Home";
				}
			}).then(function (data) {
				console.log(data);
			}).catch(function (error) {
				console.warn(error);
			});
		});
	}
	
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
