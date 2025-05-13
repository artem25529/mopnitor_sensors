const deleteSensorForm = document.getElementById('delete-sensor-form');

function handleSensorDelete() {
    const id = event.target.closest('tr[data-id]').dataset.id;
    deleteSensorForm.action += id;
}