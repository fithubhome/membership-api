const baseUrl = 'http://localhost:8085/membershipHistory';

async function getMembershipHistoryById() {
    const id = document.getElementById('membershipId').value;
    const response = await fetch(`${baseUrl}/${id}`);
    const data = await response.json();
    document.getElementById('resultById').innerText = JSON.stringify(data, null, 2);
}

async function getMembershipHistoryByProfileId() {
    const profileId = document.getElementById('profileId').value;
    const url = profileId ? `${baseUrl}?profileId=${profileId}` : baseUrl;
    const response = await fetch(url);
    const data = await response.json();
    document.getElementById('resultByProfileId').innerText = JSON.stringify(data, null, 2);
}

async function createMembershipHistory() {
    const profileId = document.getElementById('createProfileId').value;
    const details = document.getElementById('createDetails').value;
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ profileId, details })
    });
    const data = await response.json();
    document.getElementById('createResult').innerText = JSON.stringify(data, null, 2);
}

async function updateMembershipHistory() {
    const id = document.getElementById('updateId').value;
    const profileId = document.getElementById('updateProfileId').value;
    const details = document.getElementById('updateDetails').value;
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ profileId, details })
    });
    const data = await response.json();
    document.getElementById('updateResult').innerText = JSON.stringify(data, null, 2);
}

async function deleteMembershipHistory() {
    const id = document.getElementById('deleteId').value;
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'DELETE'
    });
    if (response.status === 204) {
        document.getElementById('deleteResult').innerText = 'Successfully deleted';
    } else {
        document.getElementById('deleteResult').innerText = 'Failed to delete';
    }
}
