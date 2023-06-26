var express = require('express');
const res = require('express/lib/response');
var app = express();

var projects = [
    {id: 1, name: 'Refactor Main web App', isActive: false},
    {id: 2, name: 'The LOTRY App', isActive: false},
    {id: 3, name: 'Time Tracker', isActive: true},
    {id: 4, name: 'Payroll Runner', isActive: true}
];

app.get('/projects', (req, res) => {
    res.json(projects);
});

app.get('/projects/:id', (req, res) => {
    var projectId = parseInt(req.params.id);
    var project = projects.find(p => p.id === projectId);

    if (project) {
        res.json(project);
    } else {
        res.status(404).json({ message: 'Project not found' });
    }
});

app.get('/projects/search', (req, res) => {
    var { query } = req.query;

    if (!query) {
        res.status(400).json({ message: 'Missing search query' });
        return;
    }

    var results = projects.filter(p => 
        p.name.toLowerCase().includes(query.toLowerCase()) ||
        p.isActive.includes(query)
    );

res.json(results);
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});