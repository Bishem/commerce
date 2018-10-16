package com.commerce.expedition.business.service;

import com.commerce.expedition.persistence.model.Expedition;

public interface ExpeditionService {

    Expedition readExpedition(final Long id);

    Expedition createExpedition(final Expedition expedition);

    Expedition updateExpedition(final Expedition expedition);
}
