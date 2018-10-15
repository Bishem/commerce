package com.commerce.expedition.business.service;

import com.commerce.expedition.persistence.model.Expedition;

public interface ExpeditionService {

    Expedition getExpedition(final Long id);

    Expedition postExpedition(final Expedition expedition);

    Expedition patchExpedition(final Expedition expedition);
}
