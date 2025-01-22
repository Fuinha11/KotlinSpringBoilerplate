INSERT INTO public.organization
(id, owner_id, display_name, organization_type)
VALUES('5a77d0f5-7a82-463f-ab72-bab8abef7db2'::uuid, NULL, 'ADMIN ORG', 'ADMIN');

INSERT INTO public.user_example
(id, organization_id, display_name, "role")
VALUES('cb183e77-8b9a-4cfa-91d3-4e72f2b9ced4'::uuid, '5a77d0f5-7a82-463f-ab72-bab8abef7db2'::uuid, 'ADMIN USER', 'ADMIN');

UPDATE public.organization
SET owner_id='cb183e77-8b9a-4cfa-91d3-4e72f2b9ced4'::uuid
WHERE id='5a77d0f5-7a82-463f-ab72-bab8abef7db2'::uuid;