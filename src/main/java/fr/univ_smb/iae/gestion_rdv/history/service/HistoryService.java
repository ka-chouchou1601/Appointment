package fr.univ_smb.iae.gestion_rdv.history.service;

import fr.univ_smb.iae.gestion_rdv.history.HistoryModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    private final List<HistoryModel> historyEntries = new ArrayList<>();

    // Retrieve all history entries
    public List<HistoryModel> getAllHistory() {
        return historyEntries;
    }

    // Add a new history entry
    public HistoryModel addHistoryEntry(HistoryModel historyEntry) {
        historyEntries.add(historyEntry);
        return historyEntry;
    }

    // Remove a history entry by ID
    public void removeHistoryEntry(Long id) {
        historyEntries.removeIf(entry -> entry.getId().equals(id));
    }
}
