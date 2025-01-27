INSERT INTO public.organization
(id, display_name, organization_type)
VALUES('5a77d0f5-7a82-463f-ab72-bab8abef7db2'::uuid, 'ADMIN ORG', 'ADMIN');

INSERT INTO public.user_example
(id, organization_id, email, pass, display_name, "role")
VALUES('cb183e77-8b9a-4cfa-91d3-4e72f2b9ced4'::uuid, '5a77d0f5-7a82-463f-ab72-bab8abef7db2'::uuid, 'string', '$2a$10$qTGIMkFnLSqoZSAZ7phA9ummAFQvSL7sk4hJpAnrPCPslVx3CEufa', 'ADMIN USER', 'ADMIN');