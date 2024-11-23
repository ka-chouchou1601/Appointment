package fr.univ_smb.iae.gestion_rdv.history.controller;

import fr.univ_smb.iae.gestion_rdv.history.HistoryModel;
import fr.univ_smb.iae.gestion_rdv.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    // Endpoint to retrieve all history entries
    @GetMapping
    public List<HistoryModel> getHistory() {
        return historyService.getAllHistory();
    }

    // Endpoint to add a new history entry
    @PostMapping
    public HistoryModel addHistoryEntry(@RequestBody HistoryModel historyEntry) {
        return historyService.addHistoryEntry(historyEntry);
    }

    // Endpoint to remove a history entry by ID
    @DeleteMapping("/{id}")
    public void removeHistoryEntry(@PathVariable Long id) {
        historyService.removeHistoryEntry(id);
    }
}
